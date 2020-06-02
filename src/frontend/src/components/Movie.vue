<template v-slot:default>
    <div>
        <div>
            <router-link to="/">
                <img id="google" src="https://www.google.com/logos/doodles/2020/stay-and-play-at-home-with-popular-past-google-doodles-halloween-2016-6753651837108773-2xa.gif" title="Google">
            </router-link>
        </div>
        <div>
            검색 된 결과 수 : {{pager.rowCount}}
        </div>
        <v-simple-table>
            <thead>
            <tr>
                <th class="text-left">순위</th>
                <th class="text-left">영화명</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="item of list" :key="item.name">
                <td>{{ item.seq }}</td>
                <td>{{ item.title }}</td>
            </tr>
            </tbody>
        </v-simple-table>

        <div class="text-center">
            <div style="margin: 0 auto; width:500px; height: 100px;"></div>
            <span v-if="pager.existPre"
                    style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px">PRE</span>
            <span v-for="n of pages" :key="n"
                    style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px">{{n}}</span>
            <span v-if="pager.existNext"
                    style="width: 50px; height: 50px; border: 1px solid black; margin-right: 5px">NEXT</span>
           <!-- <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>-->
        </div>


    </div>
</template>

<script>
    import { mapState } from "vuex";
    import axios from "axios";
    export default {
        data() {
            return {
                pageNumver: 0,
                pages : [],
                list : [],
                pager : {},
                totalCount : ''
            };
        },
        created() {
            alert('MOVIE _ created run :)')
            axios.get(`${this.$store.state.search.context}/movies/${this.$store.state.search.searchWord}/${this.$store.state.search.pageNumber}`)
                .then(res=>{
                    res.data.list.forEach(elem => {this.list.push(elem)})
                    this.pager = res.data.pager
                    let i = this.pager.pageStart + 1
                    let arr = []
                    console.log(`pageEnd : ${this.pager.pageEnd}`)
                    for(; i <= this.pager.pageEnd + 1 ; i++){
                        arr.push(i)
                    }
                    this.pages = arr
                })
                .catch(err=>{
                    alert(`movie cooomit fail :: ${err}`)
                })

        },
        computed : {
            ...mapState({

            })
        }
    };
</script>

<style scoped>
    #google{
        float :left;
        display: block;
        width: 180px;
    }
    #search{
        float: left;
        display: block;
        width: 400px;
        height: 40px;
        font-size: 15pt;
        box-shadow: 3px 3px 5px #C3C3C3;
        border: 1px solid #EAEAEA;
    }
    #box{
        text-align: center;
    }
    #google_search{
        width: 135px;
        height: 40px;
        border: none;
        background-color: #F4F4F4;
        font-weight: bold;
        color: grey;
    }


</style>