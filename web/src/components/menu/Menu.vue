<template>
    <nav class="header-menu">
        <ul>
            <MenuItem path="/" :name="locale.menu.home"/>
            <MenuItemDelimiter/>
            <MenuItem path="/projects" :name="locale.menu.projects"/>
            <MenuItemDelimiter/>
            <MenuItem path="/profile" :name="locale.menu.profile"/>
        </ul>
    </nav>
</template>
<script setup lang="ts">
import MenuItemDelimiter from "@/components/menu/MenuItemDelimiter.vue";
import MenuItem from "@/components/menu/MenuItem.vue";
import {locale} from "@/locale/locale";
</script>