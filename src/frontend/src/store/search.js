import router from "../router"

const state = {
    context : 'http://localhost:5000',
    soccer : [],
    movies : [],
    music : [],
    pager : {},
    pageNumber : 0,
    searchWord : 'null'
}

const actions = {
    async find({commit},searchWord){
        commit('TEST',searchWord)
        switch (searchWord) {
            case '영화':
                router.push('/movie')
                break
            case '음악':
                router.push('/music')
                break
            case '축구':
                router.push('/soccer')
                break
          }
        }
}
const mutations = {
    TEST() {
        alert('mutation.soccer')
        state.pager = {}
    },
    MOVIE(state, data) {
        state.movies = [];
        state.pager = data.pager;
        data.list.forEach(item => {
            state.movies.push({
                seq : item.seq,
                title : item.title
            })
        })
    }
}
const getters = {}

export default {
    name : 'search',
    namespaced : true,
    state,actions,mutations,getters
}