import {Module} from "vuex";
import {requestToken} from "@/utils/requests";

const authStore: Module<any, any> = {
    namespaced: true,
    state: {
        authToken: null,
    },
    getters: {
        authToken: state => state.authToken,
        authenticated: state => !!state.authToken,
    },
    actions: {
        async authenticate({commit}, {username, password}) {
            try {
                let token = requestToken(username, password)
                commit('login', token)
                return 'success'
            }
            catch (error) {
                commit('logout')
                throw error
            }
        },
    },
    mutations: {
        login(state, token) {
            state.authToken = token;
        },
        logout(state) {
            state.authToken = null;
        }
    }
}

export default authStore;
