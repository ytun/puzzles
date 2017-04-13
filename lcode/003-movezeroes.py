class Solution:

	def __init__(self,nums):
		self.nums=nums

	def findFirstZero(self, i):

		#find first zero index (one-time thing)
		while( i < len(self.nums) ):	
			if(self.nums[i]==0):
				#if zero is found/exists, find first digit followed by the first zero
				#(checking if no zero exists, or found zero)
				return i

			i+=1

		return i ### return i as well!!


	def moveZeroes(self):

		"""
		idea: bubble zero to the left
		The first zero is swapped with the first digit on the left of the first zero
		"""
		i = 0
		ind_digit = -1

		#ind_zero=self.findFirstZero(i)

		zeroFound=False

		#find first digit index followed by the first zero
		while( i < len(self.nums) ):

			if (not zeroFound):
				ind_zero=self.findFirstZero(i)
				
				zeroFound=True
				#print "ind_zero_: ", ind_zero

				i=ind_zero +1

				#i+=1 #move to next number after zero for digit finding



			#if digit is found
			if (self.nums[i]!=0):
				ind_digit=i

				#print "ind_digit: ", ind_digit
				
				#swap digit and zero 
				self.nums[ind_digit], self.nums[ind_zero] = self.nums[ind_zero], self.nums[ind_digit] 
				#ind_zero=ind_digit #useless cus not first zero
				#ind_digit is unknown- find it

				#find zero after the old digit
				#print "\nswap:\n", nums

				ind_digit=ind_zero

				#print "here: index new", ind_digit
				i=ind_digit 

				zeroFound=False


			i+=1 # for next digit finding

			#print "next start index: ", i
		
		return self.nums

nums=[0,1,0,4,3,12,0,15,0,0,20]
print nums
sol=Solution(nums)
print sol.moveZeroes()

# 	def main():
# 		sol= Solution()
# 		nums=[0,1,0,3,12]
# 		print moveZeros(nums)


# if __name__=="__main__"
# 	main()

