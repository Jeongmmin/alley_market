## 🍎 AlleyMarket Read Me

> 코로나 19로 인해 침체된 전통시장상권의 활성화를 위해 전통시장에 배달서비스를 접목시킨 사이트입니다.
사용자들은 좋은 물건을 편리하게 구매할 수 있고, 시장에서는 젊은 층의 구매자를 확보할 수 있어서 상생을 이룰 수 있습니다. 
또한 배달음식을 많이 시켜먹는 젊은 층들도 간편하게 건강한 식사를 할 수 있도록 시장물건들로 구성된 밀키트도 판매합니다.

<br/>

<p align="center">
<a href="http://18.222.233.235:9000/" target="_blank"><img src="https://img.shields.io/badge/사이트링크-000000?style=flat-square&logo=SitePoint&logoColor=white"/></a>
</p>
<h6 align="center">(ctrl + click시 새창열기 가능)</h6>

<br/>

## 📝 Skill & Preview
<p align="center">
<img src="https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=HTML5&logoColor=white"/> &nbsp
<img src="https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=CSS3&logoColor=white"/> &nbsp
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"/> &nbsp
<img src="https://img.shields.io/badge/Vue.js-4FC08D?style=flat-square&logo=Vue.js&logoColor=white"/> &nbsp
<img src="https://img.shields.io/badge/Spring Boot-47A248?style=flat-square&logo=Spring Boot&logoColor=white"/> &nbsp 
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/> &nbsp 
<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logoColor=white"/> &nbsp 
<img src="https://img.shields.io/badge/Amazon AWS-232F3E?style=flat-square&logo=Amazon%20AWS&logoColor=white"/> &nbsp </p>
<br/>
<br/>


## ⚠ Installation

### **Project setup**

```jsx
npm install
```

### **Compiles and hot-reloads for development**

```jsx
npm run serve
```

<br/>

## 🔍 기능설명

### 1. 관리자

- 로그인 : 로그인 시 바로 관리자 메인 화면으로 이동

- 공지사항 : 글쓰기, 삭제, 수정 가능

- 회원정보 : 회원리스트와 간단 정보를 확인가능하며, 회원을 삭제가능

- 상품재고 : 재고상황을 파악가능하며, 재고등록 버튼을 이용하여 재고를 등록가능

- 문의관리 : 사용자가 남긴 문의를 확인가능하며, 문의에 대한 답변을 남길 수 있다. 

### 2. 사용자

- 로그인 : 로그인 시 Index페이지로 이동되며 상품리스트를 볼 수 있고, 상품구입이 가능하다

- 장바구니 : 상품목록에서 상품을 클릭하면 상세페이지로 이동하는데, 상품의 수량을 입력한 후 장바구니 버튼을 누르면 장바구니로 이동한다.

- 상품구매 : Header 부분에 장바구니 버튼을 누르면 각 회원이 장바구니에 담은 상품을 볼 수 있고, 구매하기 버튼을 눌러 구매가능하다.

- 주문하기 : 다음 API를 활용한 주소 부분을 입력하고, 개인정보와, 총 금액을 확인한 뒤 배송메시지를 선택한 후 주문하기를 누르면 DB에 저장되면서 주문이 성공한다.

- 마이페이지 : 마이페이지로 이동하면 주문한 상품목록을 확인가능하고, 리뷰가 작성가능하다. 작성한 리뷰는 상품의 상세페이지 아래에 등록되며 상세페이지 선택시 확인이 가능하다.
