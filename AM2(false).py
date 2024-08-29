def greedy(num_l):
    num_l = sorted(num_l)
    modified = []
    total = 0
    for i in range(len(num_l)//2):
        res = num_l[2*i] + num_l[2*i+1]
        total += res
        modified.append(res)
    if len(num_l) % 2 == 1:
        modified.append(num_l[-1])
    return total, modified


c = int(input())
for _ in range(c):
    n = int(input())
    nums = list(map(int, input().split()))
    ret = 0
    if len(nums) == 1:
        print(nums[0])
    else:
        while len(nums) > 1:
            r, nums = greedy(nums)
            ret += r
        print(ret)