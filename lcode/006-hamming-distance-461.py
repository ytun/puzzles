class Solution(object):

	def hammingDistance(self, x1 , x2):
		diff =0
		


		#eg. 5 = 101
		#    7 = 111
		# 5/2 = 2/2  (1)  = 1 (0) = 1 (1)
		# 7/2 = 3/2 (1)  = 1 (1) =1 (1)
		# note: bit goes from back to front
		#keep dividing x1 and x2 side by side till the quotient is 1
		# if remainder is different= means bit is different
		while (x1>1 or x2>1):  #important not and, but or... eg. 1 and 4

			if (not x1%2 == x2%2):
				diff +=1

			x1=x1//2 #quotient
			x2=x2//2 

		# don't forget to add the very last bit (most front position)
		#squaring to make sure it is positive = same as absolute value
		if (not x1%2 == x2%2):
			diff +=1

		#diff += (x1%2-x2%2)*(x1%2-x2%2) 

		return diff

def main():

	print "bit difference: ", Solution().hammingDistance(1, 4) 

if __name__=="__main__":
	main()