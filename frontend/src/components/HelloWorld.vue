<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <div id="stars">
      <h2>Select the Pattern</h2>
      <select name="ptn_list" v-model="ptn" @change="changePattern">
        <option value="ptnA">직각삼각형 - 왼쪽 아래로</option>
        <option value="ptnB">직각삼각형 - 오른쪽 위로</option>
        <option value="ptnC">다이아몬드</option>
      </select>
      <h3>How many lines? (1...100)</h3>
      <input type="number" v-model="count" @change="getNum">
    </div>
    <br>
    <div id="pattern"></div>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';

@Options({
  props: {
    msg: String
  }
})

export default class HelloWorld extends Vue {
  private msg: string = 'STARS';
  private count?: number = 0;
  private ptn: string = 'ptnA';

  private changePattern(event:Event){
    this.getNum();
    this.getPattern();
  }

  private getNum(){
    if(this.count != undefined) {
      if (this.count >= 0 && this.count <= 100) {
        if(this.ptn == 'ptnC'){
          if(this.count%2 == 0){
            this.count = undefined;
            const domEl = document.getElementById("pattern");
            if (domEl) domEl.innerHTML = '';
            alert('This is Diamond Pattern.\nPlease enter only ODD number between 1 and 99')
          }
        }
        this.getPattern();
      } else {
        alert('Please enter only number between 1 and 100')
        this.count = undefined;
      }
    }
  }
  private getPattern(){
    if(this.count != undefined) {
      let cnt:number = this.count;
      let pattern:string = '';
      let alignStyle:string = 'left';

      if (this.ptn == 'ptnA') {
        for (let i=0; i<cnt; i++) {
          for (let j=0; j<=i; j++) {
            pattern += '*';
          }
          pattern += '<br>';
        }
      } else if (this.ptn == 'ptnB') {
        alignStyle='right';
        for (let i=0; i<cnt; i++) {
          for (let j=0; j<cnt-i; j++) {
            pattern += '*';
          }
          pattern += '<br>';
        }
      } else if (this.ptn == 'ptnC') {
        alignStyle='center';
        let quo:number = Math.floor(cnt/2);
        for (let i=0; i<quo; i++) {
          for (let j=0; j<2*i+1; j++) {
            pattern += '*';
          }
          pattern += '<br>';
        }
        for (let i=quo; i>=0; i--) {
          for (let j=0; j<2*i+1; j++) {
            pattern += '*';
          }
          pattern += '<br>';
        }
      }
      const domEl = document.getElementById("pattern");
      if (domEl) {
        domEl.style.textAlign = alignStyle;
        domEl.innerHTML = pattern;
      }
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
