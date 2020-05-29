<template v-slot:default>
    <div>
        <div>
            <router-link to="/">
            <img id="google" src="https://www.google.com/logos/doodles/2020/stay-and-play-at-home-with-popular-past-google-doodles-halloween-2016-6753651837108773-2xa.gif" title="Google">
            </router-link>
        </div>

        <v-simple-table>
                <thead>
                <tr>
                    <th class="text-left">No.</th>
                    <th class="text-left">thumbnail</th>
                    <th class="text-left">title</th>
                    <th class="text-left">artist</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in bugsmusic" :key="item.name">
                    <td>{{ item.seq }}</td>
                    <td><img :src="item.thumbnail"></td>
                    <td>{{ item.title }}</td>
                    <td>{{ item.artist }}</td>
                </tr>
                </tbody>
        </v-simple-table>

        <div class="text-center">
            <v-pagination v-model="page" :length="5" :total-visible="5"></v-pagination>
        </div>


    </div>
</template>

<script>
    import { mapState } from "vuex";
    export default {
        data() {
            return {
                page: 1
            };
        },
        computed: {
            ...mapState({
                bugsmusic: state => state.crawling.bugsmusic,
                count: state => state.crawling.count
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