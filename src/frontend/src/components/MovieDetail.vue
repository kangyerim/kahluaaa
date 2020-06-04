<template>
    <div>
        <div><h3>영화 제목 : {{item.title}}</h3></div>
        <div><h3>영화 순위 : {{item.seq}}</h3></div>
    </div>
</template>

<script>
    import {mapState} from  'vuex'
    export default {
        computed : {
            ...mapState({
                item : state => state.search.item
            })
        }
    }
</script>

<style scoped>

</style>