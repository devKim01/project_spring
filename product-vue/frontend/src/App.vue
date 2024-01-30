<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  </nav>

  <PageHeader></PageHeader>
  <router-view/>
  <PageFooter></PageFooter>

  <img alt="Vue logo" src="./assets/logo.png">
  <h3><a @click="download('새 텍스트 문서.txt')">File download</a></h3>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>

<script>
  import PageHeader from "@/components/PageHeader"
  import PageFooter from "@/components/PageFooter"
  import axios from "axios";

  export default {
    name: 'App',
    components: {
      PageHeader,
      PageFooter
    },
    methods: {
      download(filename){
        axios.post('/api/file/download', null, {params :{
                                                  filename: filename,
                                                }}
                  )
                  .then(result => { 
                    const disposition = result.headers['content-disposition'];
                    const encodedFilename = disposition.split("UTF-8''")[1];
                    const filename = decodeURIComponent(encodedFilename);
                    const url = window.URL.createObjectURL(new Blob([result.data]));
                    const link = document.createElement('a');
                    link.href = url;
                    link.setAttribute('download', filename);
                    document.body.appendChild(link);
                    link.click();
                    })
                  .catch(error => {
                    if (error.response && error.response.status === 404) {
                      console.log('File Not Found.');
                    }
                  });
      }
    }
  }
</script>