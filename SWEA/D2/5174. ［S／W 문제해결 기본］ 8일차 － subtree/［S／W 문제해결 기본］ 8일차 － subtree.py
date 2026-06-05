T = int(input())

def dfs(node):
    global cnt

    cnt += 1

    if left[node]:
        dfs(left[node])

    if right[node]:
        dfs(right[node])

for tc in range(1, T + 1):
    E, N = map(int, input().split())

    arr = list(map(int, input().split()))

    left = [0] * (E + 2)
    right = [0] * (E + 2)

    for i in range(E):
        parent = arr[i * 2]
        child = arr[i * 2 + 1]

        if left[parent] == 0:
            left[parent] = child
        else:
            right[parent] = child

    cnt = 0
    dfs(N)

    print(f"#{tc} {cnt}")