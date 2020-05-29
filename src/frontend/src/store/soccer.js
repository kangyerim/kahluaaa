import axios from 'axios'
import router from "../router"

const state = {
    context : 'http://localhost:5000/',
    soccer : []
}
const actions = {
    async search({commit},searchWord){
        alert('actions wlsdlq')
        axios.get(state.context+`soccer/`+ searchWord)
            .then(({data})=>{
                commit('SEARCH', data)
                router.push('/')
                alert('soccer')
            })
            .catch(()=>{
                alert('soccer commit fail :(')
            })
    }
}
const mutations = {
    SEARCH() {
        alert('mutation.soccer')
    }
}
const getters = {}

export default {
    name : 'soccer',
    namespaced : true,
    state,actions,mutations,getters
}