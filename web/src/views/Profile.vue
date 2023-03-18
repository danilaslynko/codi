<template>
    <div>
        {{ strings.header }}
    </div>
</template>

<script lang="ts">
import {defineComponent} from 'vue'
import {locale} from "@/locale/locale";

export default defineComponent({
    name: 'Profile.vue',
    data() {
        return {
            strings: locale.profile,
        }
    }
})
</script>
