#include <iostream>

int search(int arr[], int n, int targetValue);
void reverse(int arr[], int n);
void oddFirst(int arr[], int n);
void merge(int *arr, int leftIndex, int middleIndex, int rightIndex);
void mergeSort(int arr[], int leftIndex, int rightIndex);


// Main for testing playground 
int main(){

    //-------------------------------------------------------
    int arr[] = {1, 4, 6, 5, 2, 7, 10}; // create dummy array
    int n = sizeof(arr) / sizeof(arr[0]); // calculate the number of elemnts in arr

    //-------------------------------------------------------
    std:: cout << "\nSEARCH FUNCTION TEST: \n";
    std:: cout << "----------------------------------\n";
    // Search Function Test
    int indexFound = search(arr, n, 10); 
    if(indexFound == -1) {
        std:: cout << "Value Not Found." << "\n";
    }

    //-------------------------------------------------------
    // odd first function test
    std:: cout << "\nODD FIRST FUNCTION TEST: \n";
    std:: cout << "----------------------------------\n";
    int *ptr = arr;
    oddFirst(arr, n);
    for(int i = 0; i < n; i++){
        std:: cout << "Index #" << i << ": " << *(ptr + i) << "\n";

    }

    //-------------------------------------------------------
    //Reverse Function Test 
    std:: cout << "\nREVERSE FUNCTION TEST: \n";
    std:: cout << "----------------------------------\n";
    reverse(arr, n); 
    //int *ptr = arr; <- pointer to the begining of the array
    for(int i = 0; i < n; i++){
        std:: cout << "Index #" << i << ": " << *(ptr + i) << "\n";

    }

    //-------------------------------------------------------
    int arr2[] = {38, 27, 43, 3, 9, 82, 10}; // Example array
    int len = sizeof(arr2) / sizeof(arr2[0]); // Calculate the size of the array

    std:: cout << "\nMERGE SORT TEST: \n";
    std:: cout << "----------------------------------\nv";

    std::cout << "Original array:\n";
    for(int i = 0; i < len; i++) {
        std::cout << arr2[i] << " ";
    }
    std::cout << "\n";

    // Sorting array using mergeSort
    mergeSort(arr2, 0, len - 1); // n - 1 is the index of the last element

    std::cout << "Sorted array:\n";
    for(int i = 0; i < len; i++) {
        std::cout << arr2[i] << " ";
    }
    std::cout << "\n";




    return 0; 
}

// SEARCH ELEMENT FUNCTION 
int search(int arr[], int n, int targetValue){
    // Pointer that points to the start of the array
    int *ptr = arr;
    // loop through the array
    for(int i = 0; i < n; i++){
        // loop through with pointer increasing the value each time 
        if(targetValue == *ptr){
            std:: cout << "Target Value " << targetValue << " found at index: " << i << "\n";
            return i; // return the current index 
        }
        ptr++; // move the pointer to the next element 
    }
    return -1; // return -1 if the value is not found
}

// REVERSE ARRAY FUNCTION 
void reverse(int arr[], int n){
    // Initialize two pointers: 
    int *startPtr = arr;
    int *endPtr = arr + n -1; // Points to the last element of the array
    // loop until the two pointers meet in the middle:
    while(startPtr < endPtr){
        int temp = *startPtr; // dereference to get the value
        *startPtr = *endPtr; // swap values
        *endPtr = temp; // complete the swap

        // move startPtr forward and endPtr backward
        startPtr++;
        endPtr--;
    }

}

// ODD FIRST FUNCTION 
void oddFirst(int arr[], int n){
    int tempArr[n]; // temp array to store re arranged elemnts 
    int *tempPtr = tempArr; // temp pointer to represent start of tempArr

    // add all odd numbers to tempArr using pointers
    for(int i = 0; i < n; i++){
        if(*(arr + i) % 2 != 0) {
            *tempPtr = *(arr + i); // Assign the value to the position tempPtr points to
            tempPtr++; // move tempPtr to the next position 
        }
    }

    // add all even numbers to tempArr using pointers
    for(int i = 0; i < n; i++){
        if(*(arr + i) % 2 == 0){
            *tempPtr = *(arr + i);
            tempPtr++; 
        }
    }

    // copy elements into origional aray
    int *arrPtr = arr;
    // copy tempArr back to arr using pointers 
    for(int i = 0; i < n; i++){
        *(arrPtr + i) = *(tempArr + i);
    }

}

// MERGE SORT FUNCTION 
void mergeSort(int arr[], int leftIndex, int rightIndex){
    if(leftIndex < rightIndex){
        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

        // Sort first and second halves
        mergeSort(arr, leftIndex, middleIndex);
        mergeSort(arr, middleIndex + 1, rightIndex);

        // Merge the sorted halves
        merge(arr, leftIndex, middleIndex, rightIndex);
    }
}

void merge(int *arr, int leftIndex, int middleIndex, int rightIndex) {
    int sizeLeft = middleIndex - leftIndex + 1;
    int sizeRight = rightIndex - middleIndex;

    // Create temporary arrays
    int leftTemp[sizeLeft], rightTemp[sizeRight];

    // Copy data to temp arrays
    for(int i = 0; i < sizeLeft; i++)
        leftTemp[i] = arr[leftIndex + i];
    for(int j = 0; j < sizeRight; j++)
        rightTemp[j] = arr[middleIndex + 1 + j];

    // Merge the temp arrays back into arr
    int i = 0; // Initial index of first subarray
    int j = 0; // Initial index of second subarray
    int k = leftIndex; // Initial index of merged subarray
    while (i < sizeLeft && j < sizeRight) {
        if (leftTemp[i] <= rightTemp[j]) {
            arr[k] = leftTemp[i];
            i++;
        } else {
            arr[k] = rightTemp[j];
            j++;
        }
        k++;
    }

    // Copy remaining elements of leftTemp[], if any
    while (i < sizeLeft) {
        arr[k] = leftTemp[i];
        i++;
        k++;
    }

    // Copy remaining elements of rightTemp[], if any
    while (j < sizeRight) {
        arr[k] = rightTemp[j];
        j++;
        k++;
    }
}