import {Commit, Module} from "vuex";

type MessageType = 'ERROR' | 'INFO' | 'WARNING'

export interface Message {
    id: number,
    type: MessageType,
    text: string,
}

let idCounter = 0;

interface State {
    messages: Message[]
}

function addExpiringMessage(event: Event, type: MessageType, commit: Commit) {
    let message: Message = {
        id: idCounter++,
        type: type,
        text: event.text,
    };
    commit('add', message)
    setTimeout(() => {
        commit('remove', message.id)
    }, event.expire || 10_000)
}

interface Event {
    text: string,
    expire: number,
}

const messages: Module<State, any> = {
    namespaced: true,
    state: {
        messages: [],
    },
    getters: {
        messages: state => state.messages,
    },
    actions: {
        addError({commit}, event: Event) {
            addExpiringMessage(event, 'ERROR', commit);
        },
        addInfo({commit}, event: Event) {
            addExpiringMessage(event, 'INFO', commit);
        },
        addWarning({commit}, event: Event) {
            addExpiringMessage(event, 'WARNING', commit);
        },
        remove({commit}, {id}) {
            commit('remove', id);
        },
        clear(context) {
            context.state.messages.forEach(m => context.commit('remove', m.id));
        }
    },
    mutations: {
        add(state, message: Message) {
            state.messages.push(message);
        },
        remove(state, id) {
            state.messages = state.messages.filter(m => m.id != id);
        }
    }
}

export default messages;
