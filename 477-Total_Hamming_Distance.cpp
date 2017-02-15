int totalHammingDistance(int* nums, int numsSize) {
    int count[32] = {0}; //for 32-bit int.
    int i, sum = 0;
    for (i = 0; i < numsSize; ++i) {
        int j = 0, num = nums[i];
        while(num) {
            count[j] += (num&0x01);
            num >>=1;
            j++;
        }
    }
    for (i = 0; i < 32; i++) {
        sum += count[i] * (numsSize - count[i]);
    }
    return sum;
}

