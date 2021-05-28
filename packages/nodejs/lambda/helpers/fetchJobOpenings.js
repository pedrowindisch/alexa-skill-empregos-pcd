const urls = require("../urls.json");
const axios = require("axios");

const requester = axios.create({
  baseURL: urls.base_url
});

module.exports = (location, query, cb) => {
  return new Promise((resolve, reject) => {
    requester.post("6c2d0b3e-62b9-41b9-81b2-b8e12c948173", {
      keywords: "pcd",
      location
    }).then(response => {
      const jobs = response.data.jobs.slice(0, 3);
      console.log(jobs);

      resolve(jobs);
    }).catch(err => {
      console.error(err);
      reject();
    })
  })
} 