class Solution():
	

	def nextGreaterElement(self, findNums, nums):

		nextBigList = []

		for n in findNums:

			cur_i = nums.index(n)
			# print "cur_i: {}".format(cur_i)

			nextBig = -1

			cur = nums[cur_i]

			next = -1
			if cur_i+1 <= len(nums)-1 :
				next = nums[cur_i+1]
				# print "next: {}".format(next)

			#loop rest of numbers on right to find next big
			#as long as next is smaller and not the end
			while( cur >= next and cur_i+1 <= len(nums)-1 ):

				# print "cur_i+1: {}".format(cur_i+1)
				# print "len(nums): {}".format(len(nums))
				
				cur = nums[cur_i]
				next = nums[cur_i+1]
				
				cur_i += 1
				
			if (cur < next):
				nextBig = next
			nextBigList = nextBigList + [nextBig]

		return nextBigList


	def main(self):

		nums1 = [3,1,5,7,9,2,6]
		nums2 = [1,2,3,5,6,7,9,11]

		# nums1 = [2,4]
		# nums2 = [1,2,3,4]

		# nums1 = [4,1,2]
		# nums2 = [1,3,4,2]

		print "nums1 : {}, \n nums2: {}".format(nums1, nums2)
		print self.nextGreaterElement(nums1, nums2)

if __name__==  "__main__":
	Solution().main()