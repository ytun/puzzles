#Given two arrays, write a function to compute their intersection.

#[1, 2, 2, 1], [2,2] => [2] (unique and in any order)

class Solution:

	def intersect_array(self,arr1, arr2):

		arr=[]

		for i1 in arr1:
			for i2 in arr2:
				if i1==i2:
					arr=arr+[i1]

		print arr

Solution().intersect_array([1, 2, 2, 1], [2,2])