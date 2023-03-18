<template>
    <div class="tile" :class="$props.class">
        <slot/>
    </div>
</template>

<script>
export default {
    props: {
        class: String
    }
}
</script>
