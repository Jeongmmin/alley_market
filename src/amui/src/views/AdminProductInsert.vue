<template>
    <div class="container mr-auto">
        <div class="jumbotron text-center">
            <h1>상품등록/수정/삭제</h1>
        </div>
        <hr>

        <div class="container">
            <form>
                <div class="form-group row">
                    <label for="text" class="col-2-1 col-form-label">상품번호</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="exampleFormControlInput1" v-model="productPk">
                    </div>
                    <label for="text" class="col-sm-2-1
                    col-form-label">가게이름</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" id="exampleFormControlInput1" v-model="productStore">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="text" class="col-2-1 col-form-label">카테고리</label>
                    <div class="col-sm-4">
                        <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" v-model="productCategoryPk">
                        <!-- <option selected >카테고리 선택</option> -->
                        <!-- <option v-bind:value="{category: p1}">밀키트</option>
                        <option v-bind:value="{category: p2}">농수산물</option>
                        <option v-bind:value="{category: p3}">축산물</option>
                        <option v-bind:value="{category: p4}">식품</option>
                        <option v-bind:value="{category: p5}">기타</option> -->
                        <option value="p1">밀키트</option>
                        <option value="p2">농수산물</option>
                        <option value="p3">축산물</option>
                        <option value="p4">식품</option>
                        <option value="p5">기타</option>
                        </select>
                    </div>
                    
                    <label for="text" class="col-sm-2-1
                    col-form-label">상품가격</label>
                    <div class="col-sm-5">
                        <div class="input-group">
                            <input type="text" class="form-control" id="exampleFormControlInput1"  v-model="productPrice">
                            <div class="input-group-append">
                            <span class="input-group-text">원</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form-group row">
                    <label for="text" class="col-sm-2-1
                    col-form-label">상품수량</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="exampleFormControlInput1"  v-model="productStockCnt">
                    </div>

                    <div class="form-group row">
                    <label for="text" class="col-sm-3
                        col-form-label">대표사진</label>
                    <input type="file" class="form-control-file col" id="exampleFormControlFile1">
                    </div>
                </div>


                <div class="form-group row">
                    <label for="text" class="col-2-1 col-form-label">상품이름
                    </label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="제목을 입력하세요"  v-model="productName">
                    </div>
                </div>

                <div class="form-group row">
                    <label for="text" class="col-sm-2-1 col-form-label">상품설명</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" id="exampleFormControlTextarea1" rows="8"  v-model="productDetail"></textarea>
                    </div>
                </div>

                <div class="form-group row">
                <label for="text" class="col-sm-2 col-form-label">첨부파일</label>
                <input type="file" class="form-control-file col" id="exampleFormControlFile1">
                </div>

                <br>

                <div class="row">
                    <button type="button" class="btn btn-primary col-sm-2 ml-auto" id="btnmodi" v-on:click="moveProductStockList">목록으로</button>
                    <button type="button" class="btn btn-warning col-sm-2" id="btnmodi" v-on:click="ProductInsert">등록하기</button>
                    <!-- <button type="button" class="btn btn-danger col-sm-2">삭제하기</button> -->
                </div>
            </form> 
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            productPk:'',
            productCategoryPk:'',
            productName:'',
            productPrice:'',
            productStockCnt:'',
            productStore:'',
            productDetail:'',
        }
    },
    methods: {
        //axios를 사용하여 서버와 통신
        ProductInsert() {
            let obj = this;
            obj.$axios.post('http://localhost:9000/productInsert', {
                
                productPk: this.productPk,
                productCategoryPk: this.productCategoryPk,
                productName: this.productName,
                productPrice: this.productPrice,
                productStockCnt: this.productStockCnt,
                productStore: this.productStore,
                productDetail: this.productDetail
            })
            .then(function() {
                console.log("비동기 통신 성공");
                obj.$router.push({name:'AdminProductStock'});
                
            })
            .catch(function(err) {
                console.log("비동기 통신 실패");
                console.log(err);
            })
        },
        //리스트 화면으로 이동
        moveProductStockList() {
            this.$router.push({ name: 'AdminProductStock'});
        }
    },
    
}
</script>

<style scoped>
#btnmodi {
    margin-right: 5px;
}

#center { display: inline-block;}
</style>