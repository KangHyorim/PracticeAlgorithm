def binary_search(target):
    left = 0
    right = N - 1
    prev = 0

    while left <= right:
        mid = (left + right) // 2

        if A[mid] == target:
            return True

        elif target < A[mid]:
            if prev == 1:
                return False
            prev = 1
            right = mid - 1

        else:
            if prev == 2:
                return False
            prev = 2
            left = mid + 1

    return False


T = int(input())

for tc in range(1, T + 1):
    N, M = map(int, input().split())

    A = sorted(map(int, input().split()))
    B = list(map(int, input().split()))

    ans = 0
    for x in B:
        if binary_search(x):
            ans += 1

    print(f"#{tc} {ans}")