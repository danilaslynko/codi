<template>
    <Menu/>
    <Errors/>
    <MainView/>
    <Footer/>
</template>
<script setup lang="ts">
import Errors from '@/components/Messages.vue'
import Menu from "@/components/menu/Menu.vue";
import MainView from "@/components/MainView.vue";
import Footer from "@/components/Footer.vue";
</script>