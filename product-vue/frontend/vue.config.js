const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  outputDir: '../src/main/resources/static', //Build Dir
    devServer:{
      proxy: 'http://localhost' //Spring Boot Server
    }
})
