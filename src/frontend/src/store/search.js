import router from "../router"
import axios from "axios"

const state = {
    context : 'http://localhost:5000',
    list : [],
    pages : [],
    pager : {},
    pageNumber : 0,
    searchWord : 'null',
    item : {}
}

const actions = {
    async find({commit},searchWord){
        commit('TEST',searchWord)
        switch (searchWord) {
            case '영화':
                router.push('/movie')
                break
            case '벅스':
                router.push('/music')
                break
            case '축구':
                router.push('/soccer')
                break
          }
        },
    async transferPage({commit},payload){
        axios.get(`${state.context}/${payload.cate}/${payload.searchWord}/${payload.pageNumber}`)
            .then(({data})=>{
                commit('TRANSFER',data)
            })
            .catch()
    },
    async findOne({commit},payload){
        axios.get(`${state.context}/${payload.cate}/${payload.searchWord}`)
            .then(({data})=>{
                commit('FIND_ONE',data)
                router.push('/movieDetail')
            })
    }
}
const mutations = {
    TEST(state, data) {
        state.searchWord = data
    },
    TRANSFER(state, data){
        state.pager = data.pager
        state.list = data.list
    },
    FIND_ONE(state, data){
        state.item = data
    }
}

export default {
    name : 'search',
    namespaced : true,
    state,actions,mutations
}