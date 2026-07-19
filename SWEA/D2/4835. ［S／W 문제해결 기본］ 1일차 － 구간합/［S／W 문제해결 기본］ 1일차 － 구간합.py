T = int(input())

for tc in range(1, T + 1):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    # 첫 구간의 합
    window_sum = sum(arr[:M])

    max_sum = window_sum
    min_sum = window_sum

    # 슬라이딩 윈도우
    for i in range(M, N):
        window_sum += arr[i] - arr[i - M]

        if window_sum > max_sum:
            max_sum = window_sum
        if window_sum < min_sum:
            min_sum = window_sum

    print(f"#{tc} {max_sum - min_sum}")