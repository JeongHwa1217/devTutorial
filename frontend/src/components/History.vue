<template>
<div>
  <h1>Pattern History</h1>
  <div id="number">
    <h2>Select : {{count}}</h2>
    <input type="range" min="1" max="10" v-model="count" @change="changeCnt">
  </div>
  <br>
  <h2>History</h2>
  <div>
    <table id="patternHistory">
      <thead>
        <th width="50px">no.</th>
        <th width="200px">type</th>
        <th width="50px">num</th>
        <th>pattern</th>
      </thead>
      <tbody ref="history">
      </tbody>
    </table>
  </div>
</div>
</template>

<script lang="ts">
import { Options, Vue } from 'vue-class-component';
import axios from 'axios';

export default class History extends Vue{
  private count: number = 10;

  mounted(){
    if(sessionStorage.getItem("count")) {
      this.count = parseInt(<string>sessionStorage.getItem("count"));
    }
    this.getHistory();
  }

  private changeCnt(event:Event){
    console.log('num', this.count);
    sessionStorage.setItem("count", this.count.toString());
    this.getHistory();
  }

  private getHistory(){
    let url = 'http://localhost:8080/patternHistory/'+this.count
    let params = {
      count : this.count
    }
    const self = this;
    axios.get(url)
        .then(function (res) {
          self.setHistory(res.data);
        })
        .catch(function (ex) {
          alert('Failed to connect to server. Please contact the manager.')
          console.log('post fail', ex);
          return;
        })
  }

  private setHistory(data : any){
    console.log('axios data', data);

    let tbody = '';

    for (let i=data.length-1; i>=0; i-- ){
      console.log('data', data[i]);
      let idx = data.length-i;
      let align = 'left';
      let ptn = null;
      switch (data[i].type){
        case 'PATTERN_A' : ptn = '직각삼각형 - 왼쪽 아래로'; break;
        case 'PATTERN_B' : ptn = '직각삼각형 - 오른쪽 위로'; align = 'right'; break;
        case 'PATTERN_C' : ptn = '다이아몬드'; align = 'center'; break;
        case 'PATTERN_D' : ptn = '안정적인 계단'; break;
        case 'PATTERN_E' : ptn = '위험한 계단'; break;
      }

      let row = '<tr style="border-top : 1px solid lightgray">' +
          '<td style="border-right : 1px solid #E5E5E5">' + idx + '</td>' +
          '<td style="border-right : 1px solid #E5E5E5">' + ptn + '</td>' +
          '<td style="border-right : 1px solid #E5E5E5">' + data[i].count + '</td>' +
          '<td align =' + align + '>' + data[i].pattern + '</td>' +
          '</tr>';
      tbody += row;
    }
    (this.$refs.history as any).innerHTML = tbody;
  }

}
</script>

<style scoped>
table {
  width: 100%;
  background: snow;
  border-top: 1px solid white;
  border-collapse: collapse;
  border-radius: 5px;
  /*border-color: white;*/
}
thead {
  width: 100%;
  background: lightgray;
}
th, td {
  border-bottom: 1px solid white;
  border-left: 1px solid white;
}
th:first-child, td:first-child {
  border-left: none;
}
</style>