<template>
    <div class="container mr-auto">
        <div class="jumbotron text-center">
            <h1>공지사항</h1>
        </div>
        <hr>
        <div class="container" id="noticewri">
            <form>
                <div class="form-group row">
                    <label for="text" class="col-sm-2 col-form-label">제목</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control-plaintext" id="exampleFormControlInput1"   v-model="noticeTitle">
                    </div>
                </div>
                <div class="form-group row">
                    <label for="text" class="col-sm-2 col-form-label">작성자</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control-plaintext" id="exampleFormControlInput1" readonly  v-model="createId">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="text" class="col-sm-2 col-form-label">내용</label>
                    <div class="col-sm-10">
                        <textarea class="form-control-plaintext" id="exampleFormControlTextarea1"  rows="8" v-model="noticeContents"></textarea>
                    </div>
                </div>

                <div class="form-group row">
                <label for="text" class="col-sm-2 col-form-label">첨부파일</label>
                <input type="file" class="form-control-file col" id="exampleFormControlFile1">
                </div>

                <div class="row ">
                    <button type="button" class="btn btn-primary col-sm-1 ml-auto" id="btnwrite" v-on:click="moveNoticeList">목록으로</button>
                    <button type="button" class="btn btn-warning col-sm-1 " id="btnwrite" v-on:click="noticeUpdate">수정하기</button>
                    <button type="button" class="btn btn-danger col-sm-1 " v-on:click="noticeDelete">삭제하기</button>
                </div>
            </form> 
        </div>

        
    </div>
</template>

<script>
export default {
    data() {
        return {
            noticePk:0,
            noticeTitle:'',
            createDate:'',
            createId:'yoo',
            noticeContents:''
        }
    },
    methods: {
        moveNoticeList() {
            this.$router.push({ name:'NoticeList'});
        },
        noticeUpdate() {
            let obj =this;
            this.$axios.put('http://localhost:9000/noticeUpdate', {
                noticePk: this.noticePk,
                noticeTitle: this.noticeTitle,
                noticeContents: this.noticeContents,
                createId: this.createId
            })
            .then(function() {
                console.log('비동기 통신 성공');
                obj.$router.push({name:'NoticeList'});
            })
            .catch(function(err) {
                console.log("axios 비동기 통신 오류");
                console.log(err);
            });
        },
        noticeDelete() {
            let obj = this;
            this.$axios.delete('http://localhost:9000/noticeDelete', {
                params: {
                    noticePk: this.noticePk
                }
            })
            .then(function() {
                console.log('비동기 통신 성공');
                obj.$router.push({name:'NoticeList'});
            })
            .catch(function(err) {
                console.log("axios 비동기 통신 오류");
                console.log(err);
            });
        }
    },
    mounted() {
        let obj = this;

        //this.boardIdx = this.$route.params.boardIdx;
        obj.noticePk = obj.$route.params.noticePk;

        obj.$axios.get('http://localhost:9000/noticeDetail', {
            params: {
                noticePk: obj.noticePk
            }
        })
        .then(function(res) {
            console.log('비동기통신 성공');

            obj.noticePk = res.data.noticePk;
            obj.createDate = res.data.createDate;
            obj.createId = res.data.createId;
            obj.noticeTitle = res.data.noticeTitle;
            obj.noticeContents = res.data.noticeContents;

        })
        .catch(function(err) {
            console.log('비동기통신 실패');
            console.log(err);
        });  
    }
}
</script>

<style>
    #btnmodi {
    margin-right: 20px;
}

.contents{
    padding: 200px 100px;
    box-sizing: border-box;
    text-align: left;
}

</style>