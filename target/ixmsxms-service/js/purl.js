(function(a){if(typeof define==="function"&&define.amd){if(typeof jQuery!=="undefined"){define(["jquery"],a)}else{define([],a)}}else{if(typeof jQuery!=="undefined"){a(jQuery)}else{a()}}})(function(b,e){var q={a:"href",img:"src",form:"action",base:"href",script:"src",iframe:"src",link:"href"},t=["source","protocol","authority","userInfo","user","password","host","port","relative","path","directory","file","query","fragment"],p={anchor:"fragment"},a={strict:/^(?:([^:\/?#]+):)?(?:\/\/((?:(([^:@]*):?([^:@]*))?@)?([^:\/?#]*)(?::(\d*))?))?((((?:[^?#\/]*\/)*)([^?#]*))(?:\?([^#]*))?(?:#(.*))?)/,loose:/^(?:(?![^:@]+:[^:@\/]*@)([^:\/?#.]+):)?(?:\/\/)?((?:(([^:@]*):?([^:@]*))?@)?([^:\/?#]*)(?::(\d*))?)(((\/(?:[^?#](?![^?#\/]*\.[^?#\/.]+(?:[?#]|$)))*\/?)?([^?#\/]*))(?:\?([^#]*))?(?:#(.*))?)/},l=Object.prototype.toString,s=/^[0-9]+$/;function o(u,x){var z=decodeURI(u),w=a[x||false?"strict":"loose"].exec(z),y={attr:{},param:{},seg:{}},v=14;while(v--){y.attr[t[v]]=w[v]||""}y.param.query=f(y.attr.query);
y.param.fragment=f(y.attr.fragment);y.seg.path=y.attr.path.replace(/^\/+|\/+$/g,"").split("/");y.seg.fragment=y.attr.fragment.replace(/^\/+|\/+$/g,"").split("/");y.attr.base=y.attr.host?(y.attr.protocol?y.attr.protocol+"://"+y.attr.host:y.attr.host)+(y.attr.port?":"+y.attr.port:""):"";return y}function m(v){var u=v.tagName;if(typeof u!=="undefined"){return q[u.toLowerCase()]}return u}function c(x,w){if(x[w].length==0){return x[w]={}}var v={};for(var u in x[w]){v[u]=x[w][u]}x[w]=v;return v}function k(y,w,v,z){var u=y.shift();if(!u){if(g(w[v])){w[v].push(z)}else{if("object"==typeof w[v]){w[v]=z}else{if("undefined"==typeof w[v]){w[v]=z}else{w[v]=[w[v],z]}}}}else{var x=w[v]=w[v]||[];if("]"==u){if(g(x)){if(""!=z){x.push(z)}}else{if("object"==typeof x){x[j(x).length]=z}else{x=w[v]=[w[v],z]}}}else{if(~u.indexOf("]")){u=u.substr(0,u.length-1);if(!s.test(u)&&g(x)){x=c(w,v)}k(y,x,u,z)}else{if(!s.test(u)&&g(x)){x=c(w,v)}k(y,x,u,z)}}}}function d(y,x,B){if(~x.indexOf("]")){var A=x.split("["),u=A.length,z=u-1;
k(A,y,"base",B)}else{if(!s.test(x)&&g(y.base)){var w={};for(var v in y.base){w[v]=y.base[v]}y.base=w}i(y.base,x,B)}return y}function f(u){return h(String(u).split(/&|;/),function(v,A){try{A=decodeURIComponent(A.replace(/\+/g," "))}catch(x){}var B=A.indexOf("="),z=n(A),w=A.substr(0,z||B),y=A.substr(z||B,A.length),y=y.substr(y.indexOf("=")+1,y.length);if(""==w){w=A,y=""}return d(v,w,y)},{base:{}}).base}function i(x,w,y){var u=x[w];if(e===u){x[w]=y}else{if(g(u)){u.push(y)}else{x[w]=[u,y]}}}function n(x){var u=x.length,w,y;for(var v=0;v<u;++v){y=x[v];if("]"==y){w=false}if("["==y){w=true}if("="==y&&!w){return v}}}function h(y,v){var w=0,u=y.length>>0,x=arguments[2];while(w<u){if(w in y){x=v.call(e,x,y[w],w,y)}++w}return x}function g(u){return Object.prototype.toString.call(u)==="[object Array]"}function j(v){var u=[];for(prop in v){if(v.hasOwnProperty(prop)){u.push(prop)}}return u}function r(u,v){if(arguments.length===1&&u===true){v=true;u=e}v=v||false;u=u||window.location.toString();return{data:o(u,v),attr:function(w){w=p[w]||w;
return typeof w!=="undefined"?this.data.attr[w]:this.data.attr},param:function(w){return typeof w!=="undefined"?this.data.param.query[w]:this.data.param.query},fparam:function(w){return typeof w!=="undefined"?this.data.param.fragment[w]:this.data.param.fragment},segment:function(w){if(typeof w==="undefined"){return this.data.seg.path}else{w=w<0?this.data.seg.path.length+w:w-1;return this.data.seg.path[w]}},fsegment:function(w){if(typeof w==="undefined"){return this.data.seg.fragment}else{w=w<0?this.data.seg.fragment.length+w:w-1;return this.data.seg.fragment[w]}}}}if(typeof b!=="undefined"){b.fn.url=function(v){var u="";if(this.length){u=b(this).attr(m(this[0]))||""}return r(u,v)};b.url=r}else{window.purl=r}});