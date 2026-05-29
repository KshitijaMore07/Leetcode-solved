class Solution(object):
    def minElement(self, nums):
        def digit_sum(n):
            return sum(int(digit) for digit in str(n))

        return min(digit_sum(num) for num in nums)
        