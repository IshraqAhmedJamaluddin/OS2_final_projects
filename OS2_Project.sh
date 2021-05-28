#!/bin/bash
echo Enter a set of numbers then press q when you finish

declare -a numbers
i=0
while : ; do
  read num
  echo $num
  q1="q"
  re='^[0-9]+$'
  if [[ "$num" == "$q1" ]]; then break; fi
  if ! [[ $num =~ $re ]] ; then
     echo "error: Not a number, please try again"
  else
       echo ok
       numbers[i]=$num
       ((i++))
  fi
done

function ascending() {
   nums=("$@")
   for ((i=0;i<${#nums[*]};i++))
   do
       for ((j=i+1;j<${#nums[*]};j++))
       do
           if ((${nums[$j]}<${nums[$i]}))
           then
               temp=${nums[$j]}
               nums[$j]=${nums[$i]}
               nums[$i]=$temp
           fi
       done
   done
   
   echo "Ascending order: ${nums[*]}"
}

function descending() {
   nums=("$@")
   for ((i=0;i<${#nums[*]};i++))
   do
       for ((j=i+1;j<${#nums[*]};j++))
       do
           if ((${nums[$j]}>${nums[$i]}))
           then
               temp=${nums[$j]}
               nums[$j]=${nums[$i]}
               nums[$i]=$temp
           fi
       done
   done
   
   echo "Descending order: ${nums[*]}"
}

ascending "${numbers[@]}"
descending "${numbers[@]}"

echo "Original array: ${numbers[*]}"
