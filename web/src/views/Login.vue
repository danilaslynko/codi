<template>
    <Tile class="w-full max-w-xs">
        <form>
            <div class="mb-4">
                <label class="block text-gray-700 text-sm font-bold mb-2" for="username">
                    Username
                </label>
                <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline"
                       id="username"
                       type="text"
                       v-model="username"
                       placeholder="Username">
            </div>
            <div class="mb-6">
                <label class="block text-gray-700 text-sm font-bold mb-2" for="password">
                    Password
                </label>
                <input class="shadow appearance-none border border-red-500 rounded w-full py-2 px-3 text-gray-700 mb-3 leading-tight focus:outline-none focus:shadow-outline"
                       id="password"
                       type="password"
                       v-model="password"
                       placeholder="*****">
            </div>
            <div class="flex items-center justify-between">
                <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                        type="button"
                        @click="login">
                    Sign in
                </button>
            </div>
        </form>
    </Tile>
</template>

<script>
import {defineComponent} from 'vue'
import Tile from "@/components/Tile.vue";

export default defineComponent({
    name: "Login",
    components: {Tile},
    data() {
        return {
            username: '',
            password: '',
        }
    },
    methods: {
        login() {
            this.$store.dispatch('auth/authenticate', {
                username: this.username,
                password: this.password,
            }).then(() => {
                let originalPage = decodeURIComponent(this.$route['query']['orig']);
                this.$router.push(originalPage);
                this.$store.dispatch('messages/addInfo', {text: 'Logged in!', expire: 1_000});
            })
        }
    }
})
</script>

<style scoped>
</style>
