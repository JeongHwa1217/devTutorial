<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div id="stars">
      <h2>Select the Pattern</h2>
      <select name="ptn_list" v-model="ptn" @change="changePattern">
        <option value="ptnA">직각삼각형 - 왼쪽 아래로</option>
        <option value="ptnB">직각삼각형 - 오른쪽 위로</option>
        <option value="ptnC">다이아몬드</option>
        <option value="ptnD">안정적인 계단</option>
        <option value="ptnE">위험한 계단</option>
      </select>
      <h3>How many lines? (1...100)</h3>
      <input type="number" v-model="count" @change="getNum">
    </div>
    <br>
    <div ref="pattern"></div>
<!--    <div id="pattern"></div>-->
  </div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import axios from 'axios';

export default class HelloWorld extends Vue {
  private msg: string = 'STARS';
  private count?: number = 1;
  private ptn: string = 'ptnA';

  mounted(){
    this.getNum();
  }
  private changePattern(event:Event){
    this.getNum();
  }

  private getNum(){
    if(this.count != undefined) {
      if (this.count > 0 && this.count <= 100) {
        if(this.ptn == 'ptnC'){
          if(this.count%2 == 0){
            this.count = undefined;
            (this.$refs.pattern as any).innerHTML = '';
            alert('This is Diamond Pattern.\nPlease enter only ODD number between 1 and 99')
            return;
          }
        }
        this.getPattern();
      } else {
        (this.$refs.pattern as any).innerHTML = '';
        alert('Please enter only number between 1 and 100')
        this.count = undefined;
      }
    }
  }
  private getPattern(){
    let url = 'http://localhost:8080/pattern'
    let params = {
      ptnType : this.ptn,
      count : this.count
    };

    if(this.count != undefined) {
      let alignStyle:string = 'left';
      if(this.ptn == 'ptnB'){
        alignStyle='right';
      } else if(this.ptn == 'ptnC'){
        alignStyle='center';
      }

      const self = this;
      axios.post(url, params)
          .then(function (res) {
            (self.$refs.pattern as any).style.textAlign = alignStyle;
            (self.$refs.pattern as any).innerHTML = res.data;
          })
          .catch(function (ex) {
            alert('Failed to connect to server. Please contact the manager.')
            console.log('post fail', ex);
            return;
          });
    }
  }

}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
#pattern{
  margin: auto;
  text-align: left;
}
</style>
