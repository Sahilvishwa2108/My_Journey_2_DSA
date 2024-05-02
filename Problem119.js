/* 2666. Allow One Function Call
Given a function fn, return a new function that is identical to the original function except that it ensures fn is called at most once.

The first time the returned function is called, it should return the same result as fn.
Every subsequent time it is called, it should return undefined.
 

Example 1:

Input: fn = (a,b,c) => (a + b + c), calls = [[1,2,3],[2,3,6]]
Output: [{"calls":1,"value":6}]
Explanation:
const onceFn = once(fn);
onceFn(1, 2, 3); // 6
onceFn(2, 3, 6); // undefined, fn was not called
Example 2:

Input: fn = (a,b,c) => (a * b * c), calls = [[5,7,4],[2,3,6],[4,6,8]]
Output: [{"calls":1,"value":140}]
Explanation:
const onceFn = once(fn);
onceFn(5, 7, 4); // 140
onceFn(2, 3, 6); // undefined, fn was not called
onceFn(4, 6, 8); // undefined, fn was not called
 

Constraints:

calls is a valid JSON array
1 <= calls.length <= 10
1 <= calls[i].length <= 100
2 <= JSON.stringify(calls).length <= 1000 

solution is -
*/


 /**

     * @param {Function} fn

     * @return {Function}

     */

 var once = function (fn) {



    let hasBeenCalled = false; // Initialize a flag to track whether fn has been called



    return function (...args) {

        if (!hasBeenCalled) {

            // If fn has not been called before

            hasBeenCalled = true; // Set the flag to true to indicate that fn has been called

            return fn(...args); // Call fn with the provided arguments and return its result

        } else {

            // If fn has already been called

            return undefined; // Return undefined as specified

        }

    };

};



/**

 * let fn = (a,b,c) => (a + b + c)

 * let onceFn = once(fn)

 *

 * onceFn(1,2,3); // 6

 * onceFn(2,3,6); // returns undefined without calling fn

 */