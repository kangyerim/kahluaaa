import Vue from 'vue'
import Router from 'vue-router'

import BugsMusic from "../components/BugsMusic";
import Retrieve from "../components/Retrieve";
import RetrieveMovie from "../components/RetrieveMovie";

Vue.use(Router)

export default new Router({
    mode : 'history',
    base: process.env.BASE_URL,
    routes : [
        {path : '/', component : BugsMusic},
        {path : '/retrieve', component : Retrieve},
        {path : '/retrieveMovie', component : RetrieveMovie}
    ]
})