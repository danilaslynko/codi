import {createRouter, createWebHashHistory, RouteRecordRaw} from 'vue-router'
import Profile from '@/views/Profile.vue'
import Projects from "@/views/Projects.vue";
import store from "../store";
import Login from "@/views/Login.vue";
import Dashboards from "@/views/Dashboards.vue";

const routes: Array<RouteRecordRaw> = [
    {
        path: "/",
        name: "Home",
        component: Dashboards
    },
    {
        path: '/profile',
        name: 'Profile',
        component: Profile,
        meta: {
            requiresAuth: true
        }
    },
    {
        path: '/projects',
        name: 'Projects',
        component: Projects,
        meta: {
            requiresAuth: true
        }
    },
    {
        path: '/login',
        name: 'Login',
        component: Login,
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

router.beforeEach((to, from, next) => {
    if (to.matched.some(record => record.meta['requiresAuth']) && !store.getters['auth/authenticated']) {
        let queryBuilder = new URLSearchParams();
        if (!to.fullPath.startsWith('/login'))
            queryBuilder.set('orig', encodeURIComponent(to.fullPath));

        next(`/login?${queryBuilder.toString()}`)
    }
    else {
        next()
    }
})

export default router
