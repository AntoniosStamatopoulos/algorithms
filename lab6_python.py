import heapq

def dijkstra (graph,start,N):

    dist = [float('inf')]*N # αρχικοποιει μια λιστα με Ν στοιχεια στο (αρχικοποιημενα στα απειρο)
    dist[start] = 0

    pq = [(0,start)] # distance,  node

    while pq:

        d,u = heapq.heappop(pq)  #d= distance, u = node
        
        if d > dist[u]:
            continue
        for v,w in graph[u]:

            if (dist[v]> dist[v]+w):
                dist[v] = dist[v]+w
                heapq.heappush(pq, (dist[v],v))
                
    # megistos xronos epistrofis apo ola ta aksiotheata ektos toy ksenodoxeioy
    max_time = 0
    for i in range(N):

        if i == start :
            continue
        if dist[i] != float('inf'): # ayto prostateyei ton ypologismo apo komvous poy den einai prosvasimoi
            max_time = max(max_time, dist[i])

    return max_time



def reverse_graph(graph,N):
    reverse_graph = [[]for _ in range (N)]

    for i in range(N):
        for v,w in graph(u):
            reverse_graph[v].append((u,w))

    return reverse_graph 





def main ():

    N = 5 # arithmos twn seimiwn
    hotel = 0


    graph = [[] for _ in range (N)]


    graph[1].append((0, 5))
    graph[2].append((1, 2))
    graph[2].append((3, 1))
    graph[3].append((0, 7))
    graph[4].append((2, 3))


    reverse_g = reverse_graph(graph,N)

    max_return_time (dijkstra(reverse_graph, hotel, N))

    print (f"min time to return  at hotel:{max_return_time}")


if __name__ == "__main__":
    main()

