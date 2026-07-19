T = int(input())

for tc in range(1, T + 1):
    temp, temp_end, k = map(float, input().split())

    count = 0

    while temp > temp_end:
        count += 1
        temp *= k

    print(f"#{tc} {count}")