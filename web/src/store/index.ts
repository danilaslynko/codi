import Vuex from 'vuex'
import auth from "./auth";
import messages from "./messages";

export default new Vuex.Store({
    modules: {
        auth,
        messages
    },
})