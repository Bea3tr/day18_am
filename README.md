### docker commands

1. docker --version
2. docker image ls
3. docker container ls
4. docker ps
5. docker ps -a

6. docker image build -t bea3tr/day18_am:0.0.1 .
7. docker run -d -p 8005:4000 bea3tr/day18_am:0.0.1 .
8. docker container stop <first 4 char of container id>
9. docker container rm <first 4 char of container id>
10. docker rmi <image id>
11. docker system prune


### railway (in project root)

1. railway login --browserless 
2. railway link
3. railway up