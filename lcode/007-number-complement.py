class Solution(object):
	def findComplement(self, x):
		comp =0
		i=0

		while (x>1):

			# if bit=0, flip to 1 -> means multiply with 2^i
			if (x%2 ==0): 
				comp +=2**i

			x = x//2
			i+=1

		#always x is finally become 1 --> cus at least 1 leading 1 exists

		#edge case if x=0, cmp =1
		if i ==0:
			comp=1

		return comp


def main():

	i= 2
	print "Complement of{} is: ".format(i), Solution().findComplement(i) 

if __name__=="__main__":
	main()