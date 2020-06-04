import axios from "axios";

export const proxy = {
    methods : {
        tester(d){
            alert('proxy :: tester    '+d)
        },
        paging(d) {
        const movies =[]
        const pages = []
        let temp = {}
        axios.get(d)
            .then(({data})=>{
                data.list.forEach(elem => {movies.push(elem)})
                let pager = data.pager
                let i = pager.pageStart
                console.log(`pageEnd : ${temp.pageEnd}`)
                for(; i <= pager.pageEnd + 1 ; i++){
                    pages.push(i + 1)
                }
                temp.rowCount = pager.rowCount
                temp.existPrev = pager.existPrev
                temp.existNext = pager.existNext
                temp.nextBlock = pager.nextBlock
                temp.preBlock = pager.preBlock
            })
            .catch(err=>{
                alert(`movie cooomit fail :: ${err}`)
            })
        return {movies, pages, temp}
        }
    }
}