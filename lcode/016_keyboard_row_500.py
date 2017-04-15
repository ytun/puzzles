class Solution():
	


	first_row = ['q','w','e','r','t','y','u','i','o','p']
	second_row = ['a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l']
	third_row = ['z','x','c','v','b','n','m']

	def findWords(self,words):
		
		result = []

		# print "inL: {}".format(words)
		for word_ori in words: 
			# print "\n"
			# print "word: "+ word_ori

			word = word_ori.lower()

			row_old = -1


			for i in range(len(word)):
				c_word = word[i]
				# print "char {}: {}".format(i,c_word)

				if c_word in Solution.first_row:
					row_new=1
				elif c_word in Solution.second_row:
					row_new = 2
				else:
					row_new = 3
					
				# if not first char and different row now, break out
				if row_old > -1 and row_new != row_old:
					break
				# if either single letter or all letters same row
				elif i==len(word)-1 and (row_new==row_old or row_old == -1):
					# print "IN!"
					result = result + [word_ori]
				# keep checking the rest of letters. so far so good
				else:
					row_old=row_new

			
		return result





	def main(self):
		words = ["Hello", "Alaska", "Dad", "Peace"]
		# words = ["abdfs","cccd","a","qwwewm"]#["Hello", "Alaska", "Dad", "Peace"]
		# print "Inputs: {}".format(words)
		# print "Outpus: {}".format(self.findWords(words))


if __name__=="__main__":
	Solution().main()


# Run time- beats 19.2%
# x^3
# can be improved

