const base = {
    get() {
                return {
            url : "http://localhost:8080/ssm238f5/",
            name: "ssm238f5",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm238f5/front/index.html'
        };
            },
    getProjectName(){
        return {
            projectName: "前台点菜系统"
        } 
    }
}
export default base
