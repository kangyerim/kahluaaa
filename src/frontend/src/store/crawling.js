import axios from "axios"
import router from "../router"

const state = {
    context: "http://localhost:5000/",
    bugsmusic: [],
    movie: [],
    count: 0,
    searchWord : ''
}
const actions = {
    async search({ commit }, x) {
        axios.post(state.context + `bugsmusic`, x, {
                authorization: "JWT fefege..",
                Accept: "application/json",
                "Content-Type": "application/json"
            })
            .then(({ data }) => {
                commit("SEARCH", data)
                router.push("/retrieve")
            })
            .catch(() => {
                alert("통신 실패 !")
            })
    },
    async movie({commit},searchWord){
        axios.get(state.context+`movie/${searchWord}`)
            .then(({data})=>{
                commit('MOVIE',data)
                router.push('/retrieveMovie')
            })
            .catch(()=>{
                alert('commit fail :(')
            })
    }
}
const mutations = {
    SEARCH(state, data) {
        state.bugsmusic = [];
        state.count = data.count;
        data.list.forEach(item => {
            state.bugsmusic.push({
                seq: item.seq,
                artist: item.artists,
                title: item.title,
                thumbnail: item.thumbnail
            })
        })
    },
    MOVIE(state, data){
        state.movie = []
        state.count = data.count
        data.list.forEach(item =>{
            state.movie.push({
                seq : item.seq,
                title : item.title
            })
        })
    }
}
const getters = {
    bugsmusic: state => state.bugsmusic,
    count: state => state.count,
    movie : state => state.movie
}

export default {
    name: "crawling",
    namespaced: true,
    state,
    actions,
    mutations,
    getters
}