<template>
    <div class="footer">
        <span class="text-gray-500 text-sm">{{ copyright }}</span>
    </div>
</template>

<script>
const year = new Date().getFullYear().toString();

export default {
    data() {
        return {
            copyright: `© rrgaynullin & dslynko, ${year}`
        }
    },
    name: "Footer",
}
</script>

<style scoped>

</style>