<template>
    <p>
        {{loading && "I am working.." || employee.name}}
        
    </p>
</template>

<script>
import axios from 'axios';
export default {
    name: "employees",
    data() {
        return {
       employee: {},
       loading:false
        }
    },
    
    mounted() {
        this.loading =true;
        axios.get("http://localhost:8080/employees/1").then(response => {
            //console.log(data);
            this.employee = response.data;
            
            });
            this.loading = false;
    }
}
</script>