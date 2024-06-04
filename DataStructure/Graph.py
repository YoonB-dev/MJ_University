class Graph:
    def __init__(self):
        self.graph = {}
    
    # 노드를 추가하는 함수
    def add_node(self, node):
        if node not in self.graph:
            self.graph[node] = []
    
    # 노드 사이에 양방향 간선을 추가하는 함수
    def add_edge(self, node1, node2):
        if node1 not in self.graph:
            self.add_node(node1)
        if node2 not in self.graph:
            self.add_node(node2)
        self.graph[node1].append(node2)
        self.graph[node2].append(node1)

    # 그래프를 출력하는 함수
    def print_graph(self):
        for node in self.graph:
            print(f"{node} -> {self.graph[node]}")

# 그래프 예시
g = Graph()
g.add_edge(1, 2)
g.add_edge(1, 3)
g.add_edge(2, 4)
g.print_graph()

class Graph2:
    def __init__(self, n):
        self.n = n
        self.adj_matrix = [[0] * n for _ in range(n)]

    def add_edge(self, u, v):
        self.adj_matrix[u][v] = 1
        self.adj_matrix[v][u] = 1

    def print_graph(self):
        for row in self.adj_matrix:
            print(row)

# 그래프 생성
g = Graph2(5)
g.add_edge(0, 1)
g.add_edge(1, 2)
g.add_edge(1, 3)
g.add_edge(3, 4)
g.print_graph()

