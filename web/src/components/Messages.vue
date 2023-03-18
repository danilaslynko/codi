<template>
    <div class="global-messages">
        <div v-for="m in messages" :class="{
            'error': m.type === 'ERROR',
            'info': m.type === 'INFO',
            'warning': m.type === 'WARNING',
        }" class="message">
            <CloseButton @click="() => remove(m.id)"/>
            {{ m.text }}
        </div>
    </div>
</template>

<script>
import {defineComponent} from "vue";
import CloseButton from "@/components/CloseButton.vue";

export default defineComponent({
    name: "Messages.vue",
    components: {CloseButton},
    computed: {
        messages() {
            return this.$store.getters['messages/messages']
        }
    },
    methods: {
        remove(id) {
            this.$store.dispatch('messages/remove', {id})
        }
    }
})
</script>
