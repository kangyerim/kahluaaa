import Vue from 'vue'
import Router from 'vue-router'

import Home from "../components/Home";
import Music from "../components/Music";
import Movie from "../components/Movie";
import Soccer from "../components/Soccer";
import MovieDetail from "../components/MovieDetail";

Vue.use(Router)

export default new Router({
    mode : 'history',
    base: process.env.BASE_URL,
    routes : [
        {path : '/', component : Home},
        {path : '/music', component : Music},
        {path : '/movie', component : Movie},
        {path : '/soccer', component : Soccer},
        {path : '/movieDetail', component : MovieDetail}
    ]
})