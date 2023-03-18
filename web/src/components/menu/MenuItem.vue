<template>
    <li><router-link :to="$props.path">{{ $props.name }}</router-link></li>
</template>

<script>
export default {
    name: "MenuItem",
    props: {
        path: String,
        name: String
    }
}
</script>

<style scoped>

</style>