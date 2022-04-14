<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
<!--    <h2>First Pattern</h2>-->
<!--    <div id="pattern">-->
<!--      <ul v-for="n in 5">-->
<!--        <span v-for="m in n">*</span>-->
<!--      </ul>-->
<!--    </div>-->
    <div id="stars">
      <h3>How many lines? (1...100)</h3>
      <p></p>
      <input v-model.number="count">
      <p>{{count}}</p>
    </div>
    <div id="pattern">
      <ul v-for="n in getNum">
        <span v-for="m in n">*</span>
      </ul>
    </div>
  </div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import Component from 'vue-class-component';
// import { Watch } from 'vue-property-decorator';

@Options({
  props: {
    msg: String
  }
})

export default class HelloWorld extends Vue {
  // msg: string='hello world';
  msg: string='STARS';
  count = 0;

  onChange(num:number){
    if(num >= 0 && num<=100) {
      this.count = num;
    } else {
      alert('Please enter only number between 1 and 100')
    }
  }
  get getNum(){
    if(this.count >= 0 && this.count<=100) {
      return this.count;
    } else {
      alert('Please enter only number between 1 and 100')
      this.count = 0;
    }
    return this.count
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
  width:500px;
  text-align: left;
  //background: bisque;
}
</style>
