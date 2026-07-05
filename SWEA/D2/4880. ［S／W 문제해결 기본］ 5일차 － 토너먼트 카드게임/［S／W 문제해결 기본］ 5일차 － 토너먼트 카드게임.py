def winner(a, b):
    if cards[a] == cards[b]:
        return a

    if (cards[a] == 1 and cards[b] == 3) or \
       (cards[a] == 2 and cards[b] == 1) or \
       (cards[a] == 3 and cards[b] == 2):
        return a

    return b


def solve(l, r):
    if l == r:
        return l

    mid = (l + r) // 2

    left = solve(l, mid)
    right = solve(mid + 1, r)

    return winner(left, right)


T = int(input())

for tc in range(1, T + 1):
    N = int(input())
    cards = list(map(int, input().split()))

    ans = solve(0, N - 1)

    print(f"#{tc} {ans + 1}")