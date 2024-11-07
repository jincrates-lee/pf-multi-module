# Post-Order 멀티모듈 예제

## 모듈 의존성 그래프

![module_graph-20241107.png](docs%2Fimages%2Fmodule_graph-20241107.png)

- 위에 처럼 하면 api 모듈에서 bootJar를 만들 수가 없다. 다른 모듈에 대한 의존성이 없기 때문

api 모듈에서 bootJar를 만들기 위해서는 다음과 같이 설정해야 한다.
![module_graph-20241107-1600.png](docs%2Fimages%2Fmodule_graph-20241107-1600.png)
